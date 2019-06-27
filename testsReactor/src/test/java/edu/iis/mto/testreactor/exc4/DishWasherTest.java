package edu.iis.mto.testreactor.exc4;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DishWasherTest {

    DirtFilter dirtFilter;
    Door door;
    Engine engine;
    WaterPump waterPump;

    @Before public void setup(){
        dirtFilter = Mockito.mock(DirtFilter.class);
        door = Mockito.mock(Door.class);
        engine = Mockito.mock(Engine.class);
        waterPump = Mockito.mock(WaterPump.class);
    }

    @Test public void properlyUsedDishWasherRunShouldEndWithSuccessStatus(){
        DishWasher dishWasher = new DishWasher(waterPump,engine,dirtFilter,door);

        WashingProgram program = WashingProgram.ECO;

        ProgramConfiguration programConfiguration = ProgramConfiguration.builder().withProgram(program).withTabletsUsed(false).build();

        RunResult actualRunResult = dishWasher.start(programConfiguration);
        Assert.assertEquals(Status.SUCCESS,actualRunResult.getStatus());
    }

    @Test public void withOpenDoorsDishWasherShouldReturnDoorOpenStatus(){
        DishWasher dishWasher = new DishWasher(waterPump,engine,dirtFilter,door);
        Mockito.when(door.closed()).thenReturn(true);
        WashingProgram program = WashingProgram.ECO;

        ProgramConfiguration programConfiguration = ProgramConfiguration.builder().withProgram(program).withTabletsUsed(false).build();

        RunResult actualRunResult = dishWasher.start(programConfiguration);
        Assert.assertEquals(Status.DOOR_OPEN,actualRunResult.getStatus());
    }



    @Test
    public void test() {
        fail("Not yet implemented");
    }

}


