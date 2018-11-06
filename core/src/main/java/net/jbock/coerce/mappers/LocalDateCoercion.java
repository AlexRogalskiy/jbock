package net.jbock.coerce.mappers;

import com.squareup.javapoet.CodeBlock;

import java.time.LocalDate;
import java.util.Optional;

class LocalDateCoercion extends CoercionFactory {

  LocalDateCoercion() {
    super(LocalDate.class);
  }

  @Override
  Optional<CodeBlock> mapExpr() {
    return Optional.of(CodeBlock.of("$T::parse", LocalDate.class));
  }
}
