package com.bitspilani.thesis.schedulingtasks;

import com.bitspilani.thesis.dto.events.DatabaseStorageEventDtoDto;
import com.bitspilani.thesis.service.IngestionService;
import com.bitspilani.thesis.utils.DiskSpaceUtil;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ScheduledMetricCollectionEventTask {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    public static final String COLL_STATS = "collStats";
    public static final String STORAGE_SIZE = "storageSize";

    @Autowired
    private IngestionService ingestionService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    MongoClient mongoClient;

    @Autowired
    private Environment environment;

//    @Scheduled(fixedRate = 10000)
    public void invokeDatabaseStorageMonitoring() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        mongoTemplate.getCollectionNames().forEach(collectionName -> {
            Document  document = mongoTemplate.getDb().runCommand(new Document(COLL_STATS, collectionName));
            atomicInteger.addAndGet(document.getInteger(STORAGE_SIZE));
        });
        ingestionService.insertDatabaseStorageEvent(DatabaseStorageEventDtoDto.builder()
                .databaseEndPoint(mongoClient.getClusterDescription().getClusterSettings().getHosts().toString())
                .spaceUsed(atomicInteger.get())
                        .eventTimestamp(LocalDateTime.now())
                .build());
    }

//    @Scheduled(fixedRate = 10000)
    public void invokeSFTPStorageMonitoring() {
        ingestionService.insertSFTPStorageEvent(DiskSpaceUtil.getDiskSpace());
    }
}
