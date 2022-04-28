package ss21_design_pattern.bai_tap.use_memory;

public class BulletPool extends MemoryPool<Bullet>{
    @Override
    protected Bullet allocate() {
        return new Bullet();
    }
}
