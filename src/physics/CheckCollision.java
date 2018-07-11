package physics;

import base.GameObject;

public interface CheckCollision <T extends GameObject> {

    T checkCollision(T gameObject);
}
