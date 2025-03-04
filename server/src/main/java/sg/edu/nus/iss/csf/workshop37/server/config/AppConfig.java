package sg.edu.nus.iss.csf.workshop37.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AppConfig {
    @Value("${do.storage.key}")
    private String accessKey;

    @Value("${do.storage.secret}")
    private String secretKey;

    @Value("${do.storage.endpoint}")
    private String endPoint;

    @Value("${do.storage.endpoint.region}")
    private String endPointRegion;


    @Bean
    public AmazonS3 createS3Client() {
        System.out.println("Creating S3 client");
        System.out.println("accessKey = " + accessKey);
        System.out.println("endPoint = " + endPoint);
        System.out.println("secretKey = " + secretKey);
        System.out.println("endPointRegion = " + endPointRegion);
        
        
        BasicAWSCredentials crd
                 = new BasicAWSCredentials(accessKey, secretKey);
        EndpointConfiguration endpoint
                 = new EndpointConfiguration(endPoint, endPointRegion);
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(endpoint)
                .withCredentials(new AWSStaticCredentialsProvider(crd))
                .build();
    }
}
