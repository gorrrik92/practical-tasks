package com.walking.lesson30_regex.task4;

import java.util.ResourceBundle;

/**
 * Реализуйте программу, разбивающую исходный текст на составные части.
 * Текст – на абзацы (разделены ‘\n’), абзацы на предложения (разделены "."/ "?"/ "?!"/ "!"/ "…").
 * Предложения на слова (разделены пробелами,
 * но также могут использоваться знаки препинания ","/ "-", ":").
 * <p>
 * После этого выведите на экран исходный текст.
 * Предложения допустимо разделить точками,
 * слова – пробелами без сохранения знаков пунктуации внутри предложения.
 * Сохранение изначальной пунктуации, на мой взгляд,
 * излишне усложнит задачу и сдвинет акцент с практики регулярных выражений.
 * <p>
 * Подумайте, как наиболее корректно декомпозировать ваше решение.
 */
public class Main {
    private static final String PARAGRAPH_REGEX_DELIMETER = "\\n";
    private static final String SENTENCE_REGEX_DELIMETER = "(\\.|!|\\?|\\?!|\\.\\.\\.)\\s*";
    private static final String WORD_REGEX_DELIMETER = "\\s*(\\s|,|:|;|-)\\s*";

    private static final String SENTENCE_DELIMETER = ". ";
    private static final String WORD_DELIMETER = " ";

    private static Integer paragraphCount = 0;
    private static Integer sentenceCount = 0;
    private static Integer wordCount = 0;

    private static final String TEXT = "На Камчатке, в 2020 году, власти осуществили отличную идею, принимать покрышки от населения и платить людям 100 рублей за каждую сданную покрышку. Принимали их в сезон когда люди \"переобувают\" машины, месяц весной и месяц осенью. В первый же месяц город буквально очистился от них полностью. Люди так же как этот \"бизнесмен\" сдавали их КАМАЗами, их вытаскивали отовсюду, из самых глубоких оврагов, даже заборчики сделанные из вкопанных покрышек повыдергивали. Потом эти покрышки перерабатывали и делали покрытия из резиновой крошки которыми застилали детские и спортивные площадки. Город очистился от покрышек, были довольны и обычные люди которым стало приятно выходить на улицы и не видеть 2-3 метровые горы покрышек и те кто смог получить прибыль за свой труд на благо города.\n" +
            "Так было в первый год.\n" +
            "Потом власти увидели что их идея РАБОТАЕТ, видимо это повергло их в шок ибо никогда такого не происходило. На следующий же год, были внесены изменения в эту прекрасную идею, начали принимать покрышки по паспортам... не более 2 комплектов на человека, а это всего 800р. Т.е. Официально уже было невозможно одному человеку сдать КАМАЗ покрышек и получить прибыль. Но как то люди нашли выход и продолжили их сдавать большими объемами. Видимо к моменту сдачи на пункт приема приезжала команда друзей и покрышки раскидывались на каждого. Власти стали думать ещё активнее, как же это так, они стараются на благо жителей, а идея всё ещё работает.\n";

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        String[] paragraphs = TEXT.split(PARAGRAPH_REGEX_DELIMETER);
        for (String paragraph : paragraphs) {
            paragraphCount++;
            sentenceCount += parseParagraph(paragraph, result);
        }

        System.out.printf("Исходный текс состоит из %d параграфов, %d предложений и %d слов.\n Упрощенный текст ниже:\n", paragraphCount, sentenceCount, wordCount);
        System.out.println(result.toString());
    }

    private static  int parseParagraph(String paragraph, StringBuilder result) {
        String[] sentences = paragraph.split(SENTENCE_REGEX_DELIMETER);
        for (String sentence: sentences) {
            wordCount += parseSentence(sentence, result);
        }
        return sentences.length;
    }

    private static  int parseSentence(String sentence, StringBuilder result) {
        String[] words = sentence.split(WORD_REGEX_DELIMETER);
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i < words.length - 1) {
                result.append(WORD_DELIMETER);
            }
        }
        if (words.length > 0) {
            result.append(SENTENCE_DELIMETER);
        }
        return words.length;
    }
}
