package net.jbock.coerce.reference;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.util.HashMap;
import java.util.Map;

// mapper or collector
public abstract class AbstractReferencedType {
  
  public final DeclaredType expectedType; // subtype of Function or Collector

  AbstractReferencedType(DeclaredType expectedType) {
    this.expectedType = expectedType;
  }

  public abstract String getTypevar(String typeParameter);

  public Map<String, TypeMirror> mapTypevars(Map<String, TypeMirror> solution) {
    Map<String, TypeMirror> mapped = new HashMap<>();
    for (Map.Entry<String, TypeMirror> e : solution.entrySet()) {
      mapped.put(getTypevar(e.getKey()), e.getValue());
    }
    return mapped;
  }

  public abstract boolean isSupplier();
}