# This is my code for StringServer.java:

```
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    
    int num = 0;
    String message = "";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return message;
        } 
           
            
         else {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    num += 1;
                    message = message + String.format("%d. %s\n", num, parameters[1]);
                    return message;
                }
            }
            return "404 Not Found!";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

```

## This is what happened after I used /add-message?s=Hello
![Image]()
## This is what happened after I used /add-message?s=How are you
![Image]()
