package stepDef;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.Transformer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
// требуется только для определения формата разделителя в float и double
        return new Locale("ru");
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
// добавление в реестр определения необходимого типа
        typeRegistry.defineParameterType(new ParameterType<>(
// название параметра, используемое в определении шага:
                "localdate",
// регулярка, для поиска необходимого значения в фиче:
                "[0-9]{2}.[0-9]{2}.[0-9]{4}",
// тип параметра:
                LocalDate.class,
// функция, преобразующая входящую строку к нужному типу
                (Transformer<LocalDate>) s -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    return LocalDate.parse(s, formatter);
                }
        ));
    }
}