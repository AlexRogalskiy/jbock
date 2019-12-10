package net.jbock.coerce.either;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Either<L, R> {

  public static <L, R> Either<L, R> left(L value) {
    return new Left<>(value);
  }

  public static <L, R> Either<L, R> right(R value) {
    return new Right<>(value);
  }

  public abstract <L2, R2> Either<L2, R2> map(Function<L, L2> leftFunction, Function<R, R2> rightFunction);

  public abstract <R2> Either<L, R2> map(Function<R, R2> rightFunction);

  public abstract <R2> Either<L, R2> flatMap(Function<R, Either<L, R2>> rightFunction);

  public abstract R orElseThrow(Function<L, ? extends Throwable> f);

  public abstract boolean failureMatches(Predicate<L> predicate);
}
