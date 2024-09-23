import os
import socket
import requests
import json
from datetime import datetime

def get_folder_size(path):
    """Returns the size of the folder in bytes."""
    total_size = 0
    for dirpath, dirnames, filenames in os.walk(path):
        for f in filenames:
            fp = os.path.join(dirpath, f)
            if os.path.exists(fp):
                total_size += os.path.getsize(fp)
    return total_size

def get_disk_info(path):
    """Returns total and used space in bytes for the disk where the folder is located."""
    statvfs = os.statvfs(path)
    disk_space_allocated = statvfs.f_frsize * statvfs.f_blocks
    disk_space_used = disk_space_allocated - (statvfs.f_frsize * statvfs.f_bfree)
    return disk_space_allocated, disk_space_used

def send_data_to_api(api_url, payload):
    """Send the payload to the specified API URL."""
    headers = {'Content-Type': 'application/json'}
    try:
        print(f"Sending event data {payload}")
        response = requests.post(api_url, data=json.dumps(payload), headers=headers)
        # Output the result
        print(f"API Response: Status code {status_code}, Response text: {response_text}")
        if response.status_code == 200:
            print("Event data sent successfully.")
        else:
            print(f"Failed to send event data. Status code: {response.status_code}, Response: {response.text}")
    except requests.exceptions.RequestException as e:
        print(f"Error sending event data: {e}")



# Configuration
disk_path = '/tmp'  # Change to your folder path
collector_name = 'MonitoringAgent'
collector_version = '1.0'
event_type = 'DISK_USAGE'
collector_operating_system = {
    "OS": "Linux"
}
api_url = 'http://localhost:8081/api/events/sftp'  # Replace with actual API endpoint

# Collecting data
host_identifier = socket.gethostname()  # EC2 instance ID, for example
disk_space_allocated, disk_space_used = get_disk_info(disk_path)
event_timestamp = datetime.now().isoformat()

# Preparing payload
payload = {
    "hostIdentifier": host_identifier,
    "diskSpaceAllocated": disk_space_allocated,
    "diskSpaceUsed": disk_space_used,
    "diskPath": disk_path,
    "collectorName": collector_name,
    "collectorVersion": collector_version,
    "eventType": event_type,
    "eventTimestamp": event_timestamp,
    "collectorOperatingSystem": collector_operating_system
}

# Sending data to the API
send_data_to_api(api_url, payload)