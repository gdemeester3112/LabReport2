import java.net.URI;

class Handler implements URLHandler {
    
    StringBuilder thisMessage = new StringBuilder();

    int messageCount = 0;

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return thisMessage.toString();
        } 
        else if (url.getPath().contains("/add-message")) {
            String query = url.getQuery();
            if (query != null && query.startsWith("s=")) {
                String messageValue = query.substring(2);  
                messageCount += 1;
                thisMessage.append(messageCount).append(". ").append(messageValue).append("\n");
                return thisMessage.toString();
            }
            return "Invalid Request!";
        } else {
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
