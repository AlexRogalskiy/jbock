package net.jbock.coerce;

import net.jbock.compiler.Util;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;

abstract class SuppliedClassValidator {

  static void commonChecks(BasicInfo basicInfo, TypeElement classToCheck, String name) {
    if (classToCheck.getNestingKind() == NestingKind.MEMBER &&
        !classToCheck.getModifiers().contains(Modifier.STATIC)) {
      throw basicInfo.asValidationException(
          String.format("The nested %s class must be static.", name));
    }
    if (classToCheck.getModifiers().contains(Modifier.PRIVATE)) {
      throw basicInfo.asValidationException(
          String.format("The %s class may not be private.", name));
    }
    if (!Util.hasDefaultConstructor(classToCheck)) {
      throw basicInfo.asValidationException(
          String.format("The %s class must have a default constructor", name));
    }
  }
}
