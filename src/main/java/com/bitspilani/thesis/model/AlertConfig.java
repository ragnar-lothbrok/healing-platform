package com.bitspilani.thesis.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "alert_config")
public class AlertConfig {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String metricName;
}
