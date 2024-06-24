package ukma;

import com.squareup.javapoet.*;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.Map;

public class GenerateFactory {
    private Filer filer;
    private Map<ClassName, String> input;

    public GenerateFactory(Filer filer, Map<ClassName, String> input) {
        this.filer = filer;
        this.input = input;
    }

    void generate() throws IOException {
        for (ClassName key : input.keySet()) {
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("helloFrom" + key.simpleName())
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .addParameter(String.class, "str")
                    .addStatement("System.out.println(\"--> \" + str)");

            MethodSpec methodSpec = methodBuilder.build();
            TypeSpec helloClass = TypeSpec.classBuilder(input.get(key))
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addMethod(methodSpec)
                    .build();
            JavaFile javaFile = JavaFile.builder(key.packageName(), helloClass)
                    .build();

            javaFile.writeTo(filer);
            System.out.println("Hello ");
        }
    }
}
