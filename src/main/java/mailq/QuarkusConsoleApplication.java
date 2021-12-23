package mailq;

import javax.inject.Inject;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusConsoleApplication implements QuarkusApplication {

  @Inject
  XmlTemplateService templateService;

  @Override
  public int run(String... args) throws Exception {
    this.templateService.generateContent();
    return 0;
  }

  public static void main(String... args) {
    Quarkus.run(QuarkusConsoleApplication.class, args);
    Quarkus.blockingExit();
  }
}
