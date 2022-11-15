package agh.ics.oop;

/**
 * The interface of elements on the map.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo
 */
public interface IMapElement {

    /**
     * Returns position of an object.
     *
     * @return Position of an object.
     */
    Vector2d getPosition();

    /**
     * Returns string conversion of the element
     *
     * @return String conversion of an element.
     */
    String toString();

}