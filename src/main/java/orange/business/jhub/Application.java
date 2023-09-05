package orange.business.jhub;

import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.context.ApplicationContextConfigurer;
import io.micronaut.context.annotation.ContextConfigurer;
import io.micronaut.context.env.Environment;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.runtime.Micronaut;

// @OpenAPIDefinition(
//         info = @Info(
//                 title = "Questionnaire Training API",
//                 version = "0.0",
//                 description = "Questionnaire Training OpenAPI documentation",
//                 license = @License(name = "Apache 2.0", url = "https://foo.bar"),
//                 contact = @Contact(url = "https://sergiodelamo.com", name = "Sergio", email = "sergio.delamo@softamo.com")
//         )
// )
public class Application {

    @ContextConfigurer
    public static class DefaultEnvironmentConfigurer implements ApplicationContextConfigurer {
        @Override
        public void configure(@NonNull ApplicationContextBuilder builder) {
            builder.defaultEnvironments(Environment.TEST);
        }
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}