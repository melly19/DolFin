import requests
import os

# Define the URL for the GET request
url = "https://newsapi.org/v2/everything?q=scam&from=2024-04-30&sortBy=popularity&apiKey=a0abf9daef524912925f863595d69b59&language=en&domains=straitstimes.com,channelnewsasia.com"

# Send GET request to the URL
response = requests.get(url)

# Check if the request was successful (status code 200)
if response.status_code == 200:
    # Define the folder path
    folder_path = "app/src/main/res/raw"

    # Create the folder if it doesn't exist
    if not os.path.exists(folder_path):
        os.makedirs(folder_path)

    # Define the file path
    file_path = os.path.join(folder_path, "news2.json")

    # Write the JSON response to a file
    with open(file_path, 'w') as file:
        file.write(response.text)

    print("JSON response saved successfully.")
else:
    print("Failed to retrieve JSON response. Status code:", response.status_code)
