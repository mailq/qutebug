package mailq;

import javax.inject.Inject;
import io.quarkus.qute.Template;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusConsoleApplication implements QuarkusApplication {

  @Inject
  Template buggyTemplate;

  @Override
  public int run(String... args) throws Exception {
    System.out.println("Before templating");
    var rendered = this.buggyTemplate.data("bug", "Hello Quarkus & Associates").render();
    System.out.println(rendered);
    System.out.println("If you see this, it works");
    return 0;
  }

  public static void main(String... args) {
    Quarkus.run(QuarkusConsoleApplication.class, args);
    Quarkus.blockingExit();
  }
}
