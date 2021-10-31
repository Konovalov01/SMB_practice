package data;

import java.io.FileInputStream;
import java.io.IOException;

public class UserProperties {

    public static final String pathToProperties = "src/main/resources/Properties/AuthorizationData.properties";
    private FileInputStream fileInputStream;

    private String loginToSite,
            passwordToSite,
            startLink,
            mailLink,
            mailAdress,
            topic;

    public UserProperties() throws IOException {

        java.util.Properties authorizationProp = new java.util.Properties();
        fileInputStream = new FileInputStream(pathToProperties);
        authorizationProp.load(fileInputStream);

        loginToSite = authorizationProp.getProperty("login");
        passwordToSite = authorizationProp.getProperty("password");
        startLink = authorizationProp.getProperty("startLink");
        mailLink = authorizationProp.getProperty("mailLink");
        mailAdress = authorizationProp.getProperty("mailAdress");
        topic = authorizationProp.getProperty("topic");
    }
    public String getLogin(){
        return loginToSite;
    }

    public String getPassword(){
        return passwordToSite;
    }

    public String getStartLink(){
        return startLink;
    }

    public String getMailLink(){
        return mailLink;
    }

    public String getMailAdress(){
        return mailAdress;
    }

    public String getTopic(){
        return topic;
    }

}
