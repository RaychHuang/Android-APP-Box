Summary: Display a list of remote photos from unsplash.com

Before you begin you should already have an Android Studio project open with some boiler plater code ready for you.  This code base also is also in a git repo which will be important.  There should also be a terminal open to the git base folder, as well as the application SourceTree in case you prefer a git GUI instead of command line.

Please follow the steps outlined in order and check them off as you go.

Task 1:
- You can use any framework that you are used to (retrofit, volley, okhttp, rxjava, default android, etc.)
- The first task is only to hit the API and print out the response

- [ ] Create a branch called v0.1.0 and push it to master
- [ ] Get a response from the following API (you do not need to parse it at this time): https://api.unsplash.com/photos/?client_id=c07669ff8d4d34885f8b077982f4a25d9e89c6ca37bcbbe8ee956590a5c80e5c
- [ ] When complete, commit your changes to git

Task 2:
- You can use any framework that you are used to for parsing the json (gson, jackson, android default, etc)

- [ ] Create a branch called v0.2.0 and push it to master
- [ ] With you response object, parse the json and create data model object that containing the data we are interested in
- [ ] Under the 'urls' block, find and store the key/value pair labeled 'thumb' (You may save the field as whatever name you would like)
        - This contains the url location of the image that we want to display
- [ ] Store the key/value pair labeled 'id' (You may save the field as whatever name you would like)
        - This contains the unique image id for the image
- [ ] Create a list or array that contains all of the image data (thumb_url & id) returned by the request
- [ ] When complete, commit your changes to git

Task 3:
- You can use any framework that you are used to for displaying remote images (glide, picassor, universalimageloader, etc)

- [ ] Create a branch called v0.3.0 and push it to master
- [ ] Display the list of images in the PhotoAdapter's recycler view with using the data list that you created in Task 2
- [ ] When complete, commit your changes to git

Task 4:
- [ ] Create a branch called v1.0.0 and push it to master
- [ ] Finalize your project, do cleanup, make sure there are no bugs, add javadoc as needed.  If you feel your project is already done after Task 3 you can simply create another tag at the same commit
- [ ] When complete, commit your changes to git
