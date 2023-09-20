package orange.business.jhub.s3;

import java.net.URI;
import java.net.URISyntaxException;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;

public final class MinioUtils {

    private MinioUtils() {
    }

    public static S3Client s3Client(S3ConfigurationProperties s3Config) throws URISyntaxException {
       S3Client client = S3Client.builder()
            // .endpointOverride(new URI(s3Config.getS3Configuration().getEndpointOverride()))
            .endpointOverride(new URI("http://localhost:9000/"))
            // use local profile file instead ~/.aws/credentials
            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("admin", "password")))
            .serviceConfiguration(b -> b.pathStyleAccessEnabled(true)) // Required for minio
            .build();

        return client;
    }
}
