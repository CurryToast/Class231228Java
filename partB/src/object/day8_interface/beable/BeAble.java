package object.day8_interface.beable;

// 함수형 인터페이스
@FunctionalInterface
public interface BeAble {
	String beAble(); 
}

/**
 * InnerBeAble
 */
interface InrBeAble {
	// public이 아닌 인터페이스를 하나 더 정의할 수 있습니다.
	// 한 개의 파일에 여러개의 인터페이스를 정의할 수 있습니다.
}
