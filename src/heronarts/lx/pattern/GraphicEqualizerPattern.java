/**
 * Copyright 2013- Mark C. Slee, Heron Arts LLC
 *
 * This file is part of the LX Studio software library. By using
 * LX, you agree to the terms of the LX Studio Software License
 * and Distribution Agreement, available at: http://lx.studio/license
 *
 * Please note that the LX license is not open-source. The license
 * allows for free, non-commercial use.
 *
 * HERON ARTS MAKES NO WARRANTY, EXPRESS, IMPLIED, STATUTORY, OR
 * OTHERWISE, AND SPECIFICALLY DISCLAIMS ANY WARRANTY OF
 * MERCHANTABILITY, NON-INFRINGEMENT, OR FITNESS FOR A PARTICULAR
 * PURPOSE, WITH RESPECT TO THE SOFTWARE.
 *
 * @author Mark C. Slee <mark@heronarts.com>
 */

package heronarts.lx.pattern;

import heronarts.lx.LX;
import heronarts.lx.LXPattern;
import heronarts.lx.LXUtils;
import heronarts.lx.audio.GraphicMeter;
import heronarts.lx.color.LXColor;
import heronarts.lx.model.LXPoint;

public class GraphicEqualizerPattern extends LXPattern {

  public GraphicEqualizerPattern(LX lx) {
    super(lx);
  }

  @Override
  public void run(double deltaMs) {
    GraphicMeter eq = lx.engine.audio.meter;
    for (LXPoint p : model.points) {
      double value = eq.getBand(Math.round(p.xn * (eq.numBands - 1)));
      colors[p.index] = LXColor.gray(
        LXUtils.constrain(400. * (value - p.yn), 0, 100)
      );
    }
  }

}