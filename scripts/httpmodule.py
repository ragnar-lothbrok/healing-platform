import requests
from datetime import datetime
import socket
import sys
import platform

def check_api_status(url):
    try:
        response = requests.get(url)
        return response.status_code
    except requests.exceptions.RequestException as e:
        print(f"Error checking the API status: {e}")
        return 0

def send_event_data(api_url, collector_name, collector_version, event_type, event_timestamp, status_code, status_message):
    data = {
        "collectorName": collector_name,
        "collectorVersion": collector_version,
        "eventType": event_type,
        "eventTimestamp": event_timestamp.isoformat(),  # Convert to ISO format for JSON
        "hostIdentifier": socket.getfqdn(),
        "operatingSystem": {
            "name": sys.platform,
            "version": platform.version(),
            "architecture": platform.architecture(),
            "machine": platform.machine(),
            "processor": platform.processor(),
            "system": platform.system(),
            "release": platform.release(),
            "platform": platform.platform()
        },
        "statusCode": status_code,
        "statusMessage": status_message
    }

    print(data)
    try:
        response = requests.post(api_url, json=data)
        if response.status_code == 200:
            print("Event data sent successfully.")
        else:
            print(f"Failed to send event data. Status code: {response.status_code}, Response: {response.text}")
    except requests.exceptions.RequestException as e:
        print(f"Error sending event data: {e}")

if __name__ == "__main__":
    # Configuration
    endpoint_url = "http://localhost:8081/actuator/health"  # The API to check
    post_api_url = "https://api.example.com/events"   # The API to send event data
    collector_name = "MonitoringAgent1"
    collector_version = "1.0.0"
    event_type = "HTTP_HEALTH"
    event_timestamp = datetime.now()

    # Check API status
    status_code = check_api_status(endpoint_url)

    if status_code is not None:
        print(f"API status code: {status_code}")
        # Send event data
        send_event_data(post_api_url, collector_name, collector_version, event_type, event_timestamp, status_code, {status_code == 200 : "OK", status_code ==0 : "Not Running"}.get(True, "Failed"))