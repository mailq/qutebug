package mailq;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.transform.TransformerFactoryConfigurationError;
import io.quarkus.qute.Template;

@ApplicationScoped
public class XmlTemplateService {
  @Inject
  Template buggyTemplate;

  public void generateContent() throws TransformerFactoryConfigurationError {
    System.out.println("Before templating");
    var rendered = this.buggyTemplate.data("bug", "Hello Quarkus & Associates").render();
    System.out.println(rendered);
    System.out.println("If you see this, it works");
  }
}
