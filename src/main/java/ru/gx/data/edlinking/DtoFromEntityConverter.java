package ru.gx.data.edlinking;

import org.jetbrains.annotations.NotNull;
import ru.gx.data.DataObject;
import ru.gx.data.entity.EntityObject;

import java.util.Collection;

@SuppressWarnings("unused")
public interface DtoFromEntityConverter<DEST extends DataObject, SOURCE extends EntityObject> {

    /**
     * Поиск объекта одного типа по указанному источнику (EntityObject).
     * @param source        Объект (EntityObject), из которого берем данные.
     */
    DEST findDtoBySource(@NotNull final SOURCE source);

    /**
     * Создание объекта по источнику (EntityObject).
     * @param source        Объект (EntityObject), из которого берем данные.
     */
    DEST createDtoBySource(@NotNull final SOURCE source);

    /**
     * @param destination Объект-назначения данных.
     * @return Допустимо ли изменение объекта-назначения.
     */
    boolean isDestinationUpdatable(@NotNull final DEST destination);

    /**
     * Наполнение destination (DataObject) данными из source (EntityObject).
     * @param destination   Объект, в который загружаем данные.
     * @param source        Объект, из которого берем данные.
     */
    void updateDtoBySource(@NotNull final DEST destination, @NotNull final SOURCE source);

    /**
     * Наполнение списка результирующих объектов (DataObject) из списка объектов-источников (EntityObject).
     * @param destination   Список результирующих объектов (DataObject).
     * @param source        Источник - список объектов-источников (EntityObject).
     */
    void fillDtoCollectionFromSource(@NotNull final Collection<DEST> destination, @NotNull final Iterable<SOURCE> source);
}
