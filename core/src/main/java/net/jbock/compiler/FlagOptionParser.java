package net.jbock.compiler;

import net.jbock.com.squareup.javapoet.FieldSpec;
import net.jbock.com.squareup.javapoet.MethodSpec;
import net.jbock.com.squareup.javapoet.ParameterSpec;
import net.jbock.com.squareup.javapoet.TypeName;
import net.jbock.com.squareup.javapoet.TypeSpec;

import static java.util.Arrays.asList;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.STATIC;
import static net.jbock.com.squareup.javapoet.TypeName.BOOLEAN;
import static net.jbock.compiler.Helper.throwRepetitionErrorStatement;

/**
 * Generates the FlagOptionParser class.
 */
final class FlagOptionParser {

  static TypeSpec define(Context context) {
    FieldSpec flag = FieldSpec.builder(TypeName.BOOLEAN, "flag").build();
    return TypeSpec.classBuilder(context.flagOptionParserType())
        .superclass(context.optionParserType())
        .addMethod(readMethod(context, flag))
        .addMethod(MethodSpec.methodBuilder("flag")
            .returns(BOOLEAN)
            .addStatement("return $N", flag)
            .addAnnotation(Override.class)
            .build())
        .addField(flag)
        .addMethod(constructor(context))
        .addModifiers(PRIVATE, STATIC).build();
  }

  private static MethodSpec constructor(Context context) {
    ParameterSpec optionParam = ParameterSpec.builder(context.optionType(), "option").build();
    return MethodSpec.constructorBuilder()
        .addStatement("super($N)", optionParam)
        .addParameter(optionParam)
        .build();
  }

  private static MethodSpec readMethod(Context context, FieldSpec flag) {
    FieldSpec option = FieldSpec.builder(context.optionType(), "option").build();
    ParameterSpec token = ParameterSpec.builder(Constants.STRING, "token").build();
    ParameterSpec it = ParameterSpec.builder(Constants.STRING_ITERATOR, "it").build();
    MethodSpec.Builder spec = MethodSpec.methodBuilder("read")
        .addParameters(asList(token, it));

    spec.beginControlFlow("if ($N)", flag)
        .addStatement(throwRepetitionErrorStatement(option))
        .endControlFlow();

    spec.addStatement("$N = $L", flag, true);

    return spec.addAnnotation(Override.class).build();
  }
}