package by.pvt.module4.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.impl.client.BasicCredentialsProvider;

public class CustomCredentialsProvider extends BasicCredentialsProvider {
    public void setCredentials(Credentials credentials) {
        this.setCredentials(AuthScope.ANY, credentials);
    }
}
