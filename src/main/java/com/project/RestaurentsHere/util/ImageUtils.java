//package hr.etermin.system.util;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import java.util.Random;
//
//import com.kennycason.kumo.CollisionMode;
//import com.kennycason.kumo.WordCloud;
//import com.kennycason.kumo.WordFrequency;
//import com.kennycason.kumo.bg.PixelBoundaryBackground;
//import com.kennycason.kumo.font.scale.LinearFontScalar;
//import com.kennycason.kumo.nlp.FrequencyAnalyzer;
//import com.kennycason.kumo.palette.ColorPalette;
//
//public class ImageUtils {
//	
//	
//	public static void createTopicCloudImage(List<WordFrequency> inputFrequencies,File inputImage,String outputImagePath)
//	{
//		
//	try{
//		final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//		frequencyAnalyzer.setWordFrequenciesToReturn(300);
//		frequencyAnalyzer.setMinWordLength(4);
//		//frequencyAnalyzer.setStopWords(loadStopWords());
//
//		final List<WordFrequency> wordFrequencies = frequencyAnalyzer.loadWordFrequencies(inputFrequencies);
//		final Dimension dimension = new Dimension(1024, 1024);
//		final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
//		wordCloud.setPadding(2);
//		wordCloud.setBackgroundColor(new Color(0xFFFFFF));//new PixelBoundaryBackground("backgrounds/whale_small.png"));
//		
//		if(inputImage.exists()) {
//			System.out.println("Input Image Exists :" + inputImage.getAbsolutePath());
//		}
//		
//		InputStream input = new FileInputStream(inputImage);  //"/home/prince/wordcloud/heart-red-1024.png");
//		wordCloud.setBackground(new PixelBoundaryBackground(input));
//		
//		wordCloud.setColorPalette(new ColorPalette(new Color(0xee1122),new Color(0x4055F1), new Color(0x00ff00), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
//		wordCloud.setFontScalar(new LinearFontScalar(10, 40));
//		wordCloud.build(wordFrequencies);
//		wordCloud.writeToFile(outputImagePath);
//	
//	}catch(IOException e)
//	{
//		System.out.println("Error reading bg image-"+e.toString());
//	}
//	
//	}
//	
//	
//	public static String[] generateRandomWords(int numberOfWords)
//	{
//	    String[] randomStrings = new String[numberOfWords];
//	    Random random = new Random();
//	    for(int i = 0; i < numberOfWords; i++)
//	    {
//	        char[] word = new char[random.nextInt(8)+4]; // words of length 3 through 10. (1 and 2 letter words are boring.)
//	        for(int j = 0; j < word.length; j++)
//	        {
//	            word[j] = (char)('a' + random.nextInt(26));
//	        }
//	        randomStrings[i] = new String(word);
//	    }
//	    return randomStrings;
//	}
//
//}
