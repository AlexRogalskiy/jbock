package net.jbock.coerce.mappers;

import com.squareup.javapoet.CodeBlock;

import javax.lang.model.type.PrimitiveType;
import java.util.Optional;

abstract class BasicLongCoercion extends BasicNumberCoercion {

  BasicLongCoercion(Class<?> mapperReturnType) {
    super(mapperReturnType);
  }

  BasicLongCoercion(PrimitiveType mapperReturnType) {
    super(mapperReturnType);
  }

  @Override
  final Optional<CodeBlock> mapExpr() {
    return Optional.of(CodeBlock.of("$T::valueOf", Long.class));
  }
}
