package com.lincheng.study.alioss.enums;

public enum FileTypeEnum {

    JPG(1, "jpg"),
    GIF(2,"gif"),
    PNG(3, "png"),
    JPEG(4, "jpeg"),
    BMP(5, "bmp");

    private int key;

    private String name;

    /**
     * @param key
     * @param name
     */
    FileTypeEnum(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * @return Returns the key.
     */
    public int getKey() {
        return key;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }


    public static FileTypeEnum getFileTypeEnum(int key) {
        FileTypeEnum result = null;
        for (FileTypeEnum fileTypeEnum : values()) {
            if (fileTypeEnum.getKey() == key ) {
                result = fileTypeEnum;
                break;
            }
        }
        return result;
    }
}
