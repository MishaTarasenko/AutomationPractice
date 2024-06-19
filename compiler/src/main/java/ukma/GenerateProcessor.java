package ukma;

import com.squareup.javapoet.ClassName;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SupportedAnnotationTypes("ukma.Generate")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class GenerateProcessor extends AbstractProcessor {

    private Filer filer;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Map<ClassName, String> res = new HashMap<>();
        for (Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(Generate.class)) {
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                error("Only class can be annotated with Generate", annotatedElement);
                return true;
            }
            Generate generate = annotatedElement.getAnnotation(Generate.class);
            TypeElement typeElement = (TypeElement) annotatedElement;
            ClassName className = ClassName.get(typeElement);


            res.put(className, generate.value());
        }
        try {
            new GenerateFactory(filer, res).generate();
        } catch (IOException e) {
            error(e.getMessage());
        }

        return true;
    }

    private void error(String message, Element element) {
        messager.printMessage(Diagnostic.Kind.ERROR, message, element);
    }

    private void error(String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message);
    }
}

