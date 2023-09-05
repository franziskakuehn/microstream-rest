package orange.business.jhub.repo;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import orange.business.jhub.controller.FruitCommand;
import orange.business.jhub.model.Fruit;
import orange.business.jhub.util.FruitDuplicateException;

import java.util.Collection;
import jakarta.validation.Valid;

public interface FruitRepository {

    @NonNull
    Collection<Fruit> list();

    @NonNull
    Fruit create(@NonNull @NotNull @Valid FruitCommand fruit) // <1>
            throws FruitDuplicateException;

    @Nullable
    Fruit update(@NonNull @NotNull @Valid FruitCommand fruit); // <1>

    @Nullable
    Fruit find(@NonNull @NotBlank String name);

    void delete(@NonNull @NotNull @Valid FruitCommand fruit); // <1>

    int count();
}
