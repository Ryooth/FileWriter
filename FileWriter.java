package net.racow.coins.utils;
/*
Class created by Ryooth
03.09.2019, 21:22
*/

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FileWriter {

    private File f;
    private YamlConfiguration c;

    public FileWriter(String path, String name) {
        this.f = new File(path, name);
        this.c = YamlConfiguration.loadConfiguration(this.f);
    }

    public FileWriter set(String valuePath, Object value) {
        c.set(valuePath, value);
        return this;
    }

    public boolean exists() {
        return f.exists();
    }

    public boolean contains(String path) {
        return c.contains(path);
    }


    public Object getObject(String path) {
        return c.get(path);
    }

    public int getInt(String path) {
        return c.getInt(path);
    }

    public List<Integer> getIntList(String path) {
        return c.getIntegerList(path);
    }

    public long getLong(String path) {
        return c.getLong(path);
    }

    public List<Long> getLongList(String path) {
        return c.getLongList(path);
    }

    public short getShort(String path) {
        return (short) c.getLong(path);
    }

    public List<Short> getShortList(String path) {
        return getShortList(path);
    }

    public double getDouble(String path) {
        return c.getDouble(path);
    }

    public List<Double> getDoubleList(String path) {
        return c.getDoubleList(path);
    }

    public float getFloat(String path) {
        return (float) c.getDouble(path);
    }

    public List<Float> getFloatList(String path) {
        return c.getFloatList(path);
    }

    public String getString(String path) {
        return c.getString(path);
    }

    public List<String> getStringList(String path) {
        return c.getStringList(path);
    }

    public Set<String> getKeys(boolean deep) {
        return c.getKeys(deep);
    }

    public Object get(String path) {
        return c.get(path);
    }

    public List<?> getList(String path) {
        return c.getList(path);
    }

    public Configuration getSth(String path) {
        return c.getRoot();
    }

    public ConfigurationSection getConfigurationSection(String section) {
        return c.getConfigurationSection(section);
    }

    public FileWriter setLocation(String path, Location loc) {
        this.set(path + ".world", loc.getWorld().getName());
        this.set(path + ".x", loc.getX());
        this.set(path + ".y", loc.getY());
        this.set(path + ".z", loc.getZ());
        this.set(path + ".yaw", loc.getYaw());
        this.set(path + ".pitch", loc.getPitch());
        return this;
    }

    public Location getLocation(String path) {
        World world = Bukkit.getWorld(getString(path + ".world"));
        double x = getDouble(path + ".x");
        double y = getDouble(path + ".y");
        double z = getDouble(path + ".z");
        float yaw = getFloat(path + ".yaw");
        float pitch = getFloat(path + ".pitch");
        return new Location(world, x, y, z, yaw, pitch);
    }

    public void save() {
        try {
            c.save(f);
        } catch (IOException e) {

        }
    }

    public File getF() {
        return f;
    }

    public YamlConfiguration getC() {
        return c;
    }

}
