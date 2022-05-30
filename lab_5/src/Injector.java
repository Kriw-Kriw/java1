import annotations.AutoInjectable;
import java.io.FileReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Properties;

public class Injector {
	private Properties properties = new Properties();
	public Injector() {
		try {
			String filename = "C:\\Users\\User\\IdeaProjects\\lab_5\\resources\\props.properties";
			properties.load(new FileReader(filename));
		} catch (Exception e) {
			System.out.println("Properties file not found!");
		}
	}

	public <T> T inject(T object) {
		try {
			Class<?> injectable = object.getClass();
			Object instance = injectable.getDeclaredConstructor().newInstance();
			Field[] fields = injectable.getDeclaredFields();

			for (Field field: fields) {
				Annotation[] annotations = field.getAnnotations();
				if (Arrays.stream(annotations).anyMatch(annotation -> annotation.annotationType() == AutoInjectable.class)) {
					field.setAccessible(true);
					Class<?> fieldType = field.getType();
					String fieldTypeName = fieldType.getName();

					Object typeToInject = this.properties.get(fieldTypeName);
					String typeToInjectName = typeToInject.toString();

					Class<?> fieldClass = Class.forName(typeToInjectName);
					Object fieldInstance = fieldClass.getDeclaredConstructor().newInstance();
					field.set(instance, fieldInstance);
				}
			}
			return (T)instance;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
