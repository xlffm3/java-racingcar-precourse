package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.CarNameDuplicationException;
import racingcar.domain.strategy.RandomMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {

    @DisplayName("Cars 객체 생성 성공 : 이름들에 중복이 없는 경우")
    @Test
    public void createCars_중복없는_이름들_객체_생성_성공() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");

        assertThatCode(() -> {
            Cars.createCars(carNames, new RandomMovingStrategy());
        }).doesNotThrowAnyException();
    }

    @DisplayName("Cars 객체 생성 실패 : 이름들에 중복이 존재하는 경우")
    @Test
    public void createCars_중복있는_이름들_예외_발생() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "jiko", "ajax");

        assertThatCode(() -> {
            Cars.createCars(carNames, new RandomMovingStrategy());
        }).isInstanceOf(CarNameDuplicationException.class);
    }

    @DisplayName("Car 객체들의 이름 리스트를 반환한다.")
    @Test
    public void getCarNames_이름들이_반환된다() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());

        assertThat(cars.getCarNames()).hasSameElementsAs(carNames);
    }
}
