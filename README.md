# GetWebsiteTitle
Get the title by giving URL through creating an invisible webview.

# How to use it
in Activity 
  ~~~
  GetTitleUtilClient  client = new GetTitleUtilClient(this);
  
  client.getTitleFromUrl("https://github.com/", new GetTitleUtilClient.TitleGetListener() {
            @Override
            public void onTitleGet(String title) {
                //TODO do something you want
            }
   });
 ~~~
# Warning!
when Activity onDestroy  
~~~
    @Override
    protected void onDestroy() {
        super.onDestroy();
       
        client.destory();
    }
~~~
 
