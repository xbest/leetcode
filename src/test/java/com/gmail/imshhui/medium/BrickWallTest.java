package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: liyulin
 * Date: 2020/2/27
 */
public class BrickWallTest {
    BrickWall client = new BrickWall();

    @Test
    public void leastBricks() {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));
        Assert.assertEquals(2, client.leastBricks(wall));
    }
}
