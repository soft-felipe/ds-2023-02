package es.design;

import java.lang.reflect.Constructor;

@Observer(observado = Carro.class)
public class ExibicaoCarro implements Observador {
    private String nome;

    public ExibicaoCarro(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(Observado observado) {
        System.out.println(observado.getInfos());
    }

//    IGNORA, ERA PRA INSTANCIAR EM TEMPO DE EXECUÇÃO

    private <T extends Observado> T criaInstancia(Class<T> clazz, Object... parametros) throws Exception{
        Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypesToTypes(parametros));
        T service = constructor.newInstance(parameterTypesAndValuesToValues(parametros));
        return service;
    }

    public Class<?>[] parameterTypesToTypes(Object... parameterTypesAndValues) {
        Class<?>[] parameterTypes = new Class<?>[parameterTypesAndValues.length / 2];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypes[i] = (Class<?>) parameterTypesAndValues[i * 2];
        }
        return parameterTypes;
    }

    public Object[] parameterTypesAndValuesToValues(Object... parameterTypesAndValues) {
        Object[] values = new Object[parameterTypesAndValues.length / 2];
        for (int i = 0; i < values.length; i++) {
            values[i] = parameterTypesAndValues[i * 2 + 1];
        }
        return values;
    }
}
