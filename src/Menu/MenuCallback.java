package Menu;

public interface MenuCallback<E extends Enum> {
    void  onMenuSelected(E e, MenuController menuController);
}
