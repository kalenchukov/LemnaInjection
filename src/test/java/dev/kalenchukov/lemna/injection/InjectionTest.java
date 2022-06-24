/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.lemna.injection;

import dev.kalenchukov.lemna.injection.annotations.Converter;
import dev.kalenchukov.lemna.injection.exceptions.InvalidConverterException;
import dev.kalenchukov.lemna.injection.exceptions.IllegalValueException;
import dev.kalenchukov.lemna.injection.exceptions.UnknownConverterException;
import dev.kalenchukov.lemna.injection.supports.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InjectionTest
{
    /**
     * Проверка внедрения в одиночные типы данных.
     */
    @Test
    public void testInject1()
    {
        class Experimental
        {
            public Integer var1;
            public Short var2;
            public Float var3;
            public Double var4;
            public Long var5;
            public String var6;
            public Character var7;
            public Boolean var8;
            public Byte var9;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"1"});
        data.put("var2", new String[]{"2"});
        data.put("var3", new String[]{"3.0"});
        data.put("var4", new String[]{"4.59"});
        data.put("var5", new String[]{"1698756"});
        data.put("var6", new String[]{"text"});
        data.put("var7", new String[]{"A"});
        data.put("var8", new String[]{"true"});
        data.put("var9", new String[]{"27"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertEquals(Integer.valueOf(1), experimental.var1);
        assertEquals(Short.valueOf((short) 2), experimental.var2);
        assertEquals(Float.valueOf(3.0F), experimental.var3);
        assertEquals(Double.valueOf(4.59), experimental.var4);
        assertEquals(Long.valueOf(1698756L), experimental.var5);
        assertEquals("text", experimental.var6);
        assertEquals(Character.valueOf('A'), experimental.var7);
        assertEquals(true, experimental.var8);
        assertEquals(Byte.valueOf((byte) 27), experimental.var9);
    }

    /**
     * Проверка внедрения в массивы одиночных типов данных.
     */
    @Test
    public void testInject2()
    {
        class Experimental
        {
            public Integer[] var1;
            public Short[] var2;
            public Float[] var3;
            public Double[] var4;
            public Long[] var5;
            public String[] var6;
            public Character[] var7;
            public Boolean[] var8;
            public Byte[] var9;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"1", "11", null});
        data.put("var2", new String[]{"2", "22", null});
        data.put("var3", new String[]{"3.0", "3.30", null});
        data.put("var4", new String[]{"4.59", "59.40", null});
        data.put("var5", new String[]{"1698756", "345345346", null});
        data.put("var6", new String[]{"text", "TEXT", null});
        data.put("var7", new String[]{"A", "B", null});
        data.put("var8", new String[]{"true", "false", null});
        data.put("var9", new String[]{"27", "45", null});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertArrayEquals(new Integer[]{1, 11, null}, experimental.var1);
        assertArrayEquals(new Short[]{2, 22, null}, experimental.var2);
        assertArrayEquals(new Float[]{3.0F, 3.30F, null}, experimental.var3);
        assertArrayEquals(new Double[]{4.59, 59.40, null}, experimental.var4);
        assertArrayEquals(new Long[]{1698756L, 345345346L, null}, experimental.var5);
        assertArrayEquals(new String[] {"text", "TEXT", null}, experimental.var6);
        assertArrayEquals(new Character[]{'A', 'B', null}, experimental.var7);
        assertArrayEquals(new Boolean[]{true, false, null}, experimental.var8);
        assertArrayEquals(new Byte[]{27, 45, null}, experimental.var9);
    }

    /**
     * Проверка внедрения в {@code Collection} типы данных.
     */
    @Test
    public void testInject3()
    {
        class Experimental
        {
            public Collection<Integer> var1;
            public Collection<Short> var2;
            public Collection<Float> var3;
            public Collection<Double> var4;
            public Collection<Long> var5;
            public Collection<String> var6;
            public Collection<Character> var7;
            public Collection<Boolean> var8;
            public Collection<Byte> var9;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"1", "11", "11"});
        data.put("var2", new String[]{"2", "22", "22"});
        data.put("var3", new String[]{"3.0", "3.30", "3.30"});
        data.put("var4", new String[]{"4.59", "59.40", "59.40"});
        data.put("var5", new String[]{"1698756", "345345346", "345345346"});
        data.put("var6", new String[]{"text", "TEXT", "TEXT"});
        data.put("var7", new String[]{"A", "B", "B"});
        data.put("var8", new String[]{"true", "false", "false"});
        data.put("var9", new String[]{"27", "45", "45"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertEquals(List.of(new Integer[]{1, 11, 11}), experimental.var1);
        assertEquals(List.of(new Short[]{2, 22, 22}), experimental.var2);
        assertEquals(List.of(new Float[]{3.0F, 3.30F, 3.30F}), experimental.var3);
        assertEquals(List.of(new Double[]{4.59, 59.40, 59.40}), experimental.var4);
        assertEquals(List.of(new Long[]{1698756L, 345345346L, 345345346L}), experimental.var5);
        assertEquals(List.of(new String[] {"text", "TEXT", "TEXT"}), experimental.var6);
        assertEquals(List.of(new Character[]{'A', 'B', 'B'}), experimental.var7);
        assertEquals(List.of(new Boolean[]{true, false, false}), experimental.var8);
        assertEquals(List.of(new Byte[]{27, 45, 45}), experimental.var9);
    }

    /**
     * Проверка внедрения в {@code List} типы данных.
     */
    @Test
    public void testInject4()
    {
        class Experimental
        {
            public List<Integer> var1;
            public List<Short> var2;
            public List<Float> var3;
            public List<Double> var4;
            public List<Long> var5;
            public List<String> var6;
            public List<Character> var7;
            public List<Boolean> var8;
            public List<Byte> var9;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"1", "11", "11"});
        data.put("var2", new String[]{"2", "22", "22"});
        data.put("var3", new String[]{"3.0", "3.30", "3.30"});
        data.put("var4", new String[]{"4.59", "59.40", "59.40"});
        data.put("var5", new String[]{"1698756", "345345346", "345345346"});
        data.put("var6", new String[]{"text", "TEXT", "TEXT"});
        data.put("var7", new String[]{"A", "B", "B"});
        data.put("var8", new String[]{"true", "false", "false"});
        data.put("var9", new String[]{"27", "45", "45"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertEquals(List.of(new Integer[]{1, 11, 11}), experimental.var1);
        assertEquals(List.of(new Short[]{2, 22, 22}), experimental.var2);
        assertEquals(List.of(new Float[]{3.0F, 3.30F, 3.30F}), experimental.var3);
        assertEquals(List.of(new Double[]{4.59, 59.40, 59.40}), experimental.var4);
        assertEquals(List.of(new Long[]{1698756L, 345345346L, 345345346L}), experimental.var5);
        assertEquals(List.of(new String[] {"text", "TEXT", "TEXT"}), experimental.var6);
        assertEquals(List.of(new Character[]{'A', 'B', 'B'}), experimental.var7);
        assertEquals(List.of(new Boolean[]{true, false, false}), experimental.var8);
        assertEquals(List.of(new Byte[]{27, 45, 45}), experimental.var9);
    }

    /**
     * Проверка внедрения в {@code Set} типы данных.
     */
    @Test
    public void testInject5()
    {
        class Experimental
        {
            public Set<Integer> var1;
            public Set<Short> var2;
            public Set<Float> var3;
            public Set<Double> var4;
            public Set<Long> var5;
            public Set<String> var6;
            public Set<Character> var7;
            public Set<Boolean> var8;
            public Set<Byte> var9;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"1", "11"});
        data.put("var2", new String[]{"2", "22"});
        data.put("var3", new String[]{"3.0", "3.30"});
        data.put("var4", new String[]{"4.59", "59.40"});
        data.put("var5", new String[]{"1698756", "345345346"});
        data.put("var6", new String[]{"text", "TEXT"});
        data.put("var7", new String[]{"A", "B"});
        data.put("var8", new String[]{"true", "false"});
        data.put("var9", new String[]{"27", "45"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertEquals(Set.of(new Integer[]{1, 11}), experimental.var1);
        assertEquals(Set.of(new Short[]{2, 22}), experimental.var2);
        assertEquals(Set.of(new Float[]{3.0F, 3.30F}), experimental.var3);
        assertEquals(Set.of(new Double[]{4.59, 59.40}), experimental.var4);
        assertEquals(Set.of(new Long[]{1698756L, 345345346L}), experimental.var5);
        assertEquals(Set.of(new String[] {"text", "TEXT"}), experimental.var6);
        assertEquals(Set.of(new Character[]{'A', 'B'}), experimental.var7);
        assertEquals(Set.of(new Boolean[]{true, false}), experimental.var8);
        assertEquals(Set.of(new Byte[]{27, 45}), experimental.var9);
    }

    /**
     * Проверка внедрения {@code null} в {@code Collection}.
     */
    @Test(expected = IllegalValueException.class)
    public void testInject6()
    {
        class Experimental
        {
            public Collection<Integer> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{null});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);
    }

    /**
     * Проверка внедрения {@code null} в {@code List}.
     */
    @Test(expected = IllegalValueException.class)
    public void testInject7()
    {
        class Experimental
        {
            public List<Integer> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{null});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);
    }

    /**
     * Проверка внедрения {@code null} в {@code Set}.
     */
    @Test(expected = IllegalValueException.class)
    public void testInject8()
    {
        class Experimental
        {
            public Set<Integer> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{null});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);
    }

    /**
     * Проверка внедрения в дублирующих значений в {@code Set}.
     */
    @Test(expected = IllegalValueException.class)
    public void testInject9()
    {
        class Experimental
        {
            public Set<Integer> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"qwe", "qwe"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);
    }

    /**
     * Проверка внедрения в примитивные типы данных.
     */
    @Test(expected = UnknownConverterException.class)
    public void testInject10()
    {
        class Experimental
        {
            public int var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"1"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);
    }

    /**
     * Проверка внедрения в тип данных {@code Gender} с помощью собственного конвертера.
     */
    @Test()
    public void testInject11()
    {
        class Experimental
        {
            @Converter(converter = SingleGenderConverter.class)
            public Gender var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"M"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertEquals(Gender.M, experimental.var1);
    }

    /**
     * Проверка внедрения {@code null} в тип данных {@code Gender} с помощью собственного конвертера.
     */
    @Test()
    public void testInject12()
    {
        class Experimental
        {
            @Converter(converter = SingleGenderConverter.class)
            public Gender var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{null});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertNull(experimental.var1);
    }

    /**
     * Проверка внедрения {@code null} в тип данных {@code Gender} с помощью собственного конвертера.
     */
    @Test()
    public void testInject13()
    {
        class Experimental
        {
            @Converter(converter = SingleGenderConverter.class)
            public Gender var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", null);

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertNull(experimental.var1);
    }

    /**
     * Проверка использования неподходящего собственного конвертера типа данных.
     */
    @Test(expected = InvalidConverterException.class)
    public void testInject14()
    {
        class Experimental
        {
            @Converter(converter = SingleGenderConverter.class)
            public Gender[] var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"M", "F"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertArrayEquals(new Gender[]{Gender.M, Gender.F}, experimental.var1);
    }

    /**
     * Проверка внедрения в тип данных {@code Gender[]} с помощью собственного конвертера.
     */
    @Test
    public void testInject15()
    {
        class Experimental
        {
            @Converter(converter = ArrayOfGenderConverter.class)
            public Gender[] var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"M", "F", null});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertArrayEquals(new Gender[]{Gender.M, Gender.F, null}, experimental.var1);
    }

    /**
     * Проверка внедрения своего типа данных {@code Gender} в коллекцию {@code Collection}.
     */
    @Test
    public void testInject16()
    {
        class Experimental
        {
            @Converter(converter = CollectionOfGenderConverter.class)
            public Collection<Gender> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"M", "F"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertEquals(List.of(new Gender[]{Gender.M, Gender.F}), experimental.var1);
    }

    /**
     * Проверка внедрения своего типа данных {@code Gender} в коллекцию {@code List}.
     */
    @Test
    public void testInject17()
    {
        class Experimental
        {
            @Converter(converter = ListOfGenderConverter.class)
            public List<Gender> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"M", "F"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertEquals(List.of(new Gender[]{Gender.M, Gender.F}), experimental.var1);
    }

    /**
     * Проверка внедрения своего типа данных {@code Gender} в коллекцию {@code Set}.
     */
    @Test
    public void testInject18()
    {
        class Experimental
        {
            @Converter(converter = SetOfGenderConverter.class)
            public Set<Gender> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"M", "F"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertEquals(Set.of(new Gender[]{Gender.M, Gender.F}), experimental.var1);
    }

    /**
     * Проверка внедрения дублирующих значений {@code Gender} в коллекцию {@code Set}.
     */
    @Test(expected = IllegalValueException.class)
    public void testInject19()
    {
        class Experimental
        {
            @Converter(converter = SetOfGenderConverter.class)
            public Set<Gender> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"M", "F", "F"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);
    }

    /**
     * Проверка внедрения {@code null} в коллекцию {@code List} из своего типа данных {@code Gender}.
     */
    @Test(expected = IllegalValueException.class)
    public void testInject20()
    {
        class Experimental
        {
            @Converter(converter = ListOfGenderConverter.class)
            public List<Gender> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"M", "F", null});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);
    }

    /**
     * Проверка внедрения в поле с неизвестным типом данных.
     * В качестве неизвестного типа данных коллекция {@code List} из {@code String[]},
     * для которого нет стандартного конвертера.
     */
    @Test(expected = UnknownConverterException.class)
    public void testInject21()
    {
        class Experimental
        {
            public List<String[]> var1;
        }

        Map<String, String[]> data = new HashMap<>();
        data.put("var1", new String[]{"QWE"});

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);
    }

    /**
     * Проверка внедрения без данных.
     */
    @Test()
    public void testInject22()
    {
        class Experimental
        {
            public String var1;
        }

        Map<String, String[]> data = new HashMap<>();

        Experimental experimental = new Experimental();

        Injectable injector = new Injection(experimental);
        injector.inject(data);

        assertNull(experimental.var1);
    }
}