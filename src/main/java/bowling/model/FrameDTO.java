package bowling.model;

import bowling.model.framestatus.FrameStatus;

public class FrameDTO {

  private final KnockedDownPins pins;
  private final FrameStatus frameStatus;

  public FrameDTO(KnockedDownPins pins, FrameStatus frameStatus) {
    this.pins = pins;
    this.frameStatus = frameStatus;
  }

  public static FrameDTO createBy(Frame frame) {
    return new FrameDTO(frame.getPins(), frame.getFrameStatus());
  }

  public boolean isBonusFrame() {
    return frameStatus.isBonus();
  }

  public String getFrameResult() {
    return frameStatus.getResultBy(pins);
  }

  @Override
  public String toString() {
    return "FrameDTO{" +
        "pins=" + pins +
        ", frameStatus=" + frameStatus +
        '}';
  }
}
