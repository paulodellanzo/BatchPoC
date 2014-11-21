package batchpoc.model;

import java.io.Serializable;

public abstract class Enum implements Serializable, Comparable<Enum>
{

    private static final long serialVersionUID = 7760925308733454882L;

    private String            key;
    private String            descriptionCode;

    public Enum()
    {}

    protected Enum(String key, String descriptionCode)
    {
        this.key = key;
        this.descriptionCode = descriptionCode;
    }

    public abstract Enum[] getEnumValues();

    /**
     * @@StringField(label="key",required=true)
     * @return Returns the alias.
     */
    public String getKey()
    {
        return this.key;
    }

    /**
     * @return El key del bundle que describe a este valor de enumeracion
     */
    public String getDescriptionCode()
    {
        return this.descriptionCode;
    }

    /**
     * @@StringField(indexOnLOV=1,indexOnLOVBrowse=1,indexOnLOVChoice=1)
     * @return La descripción localizada
     */
    public String getLocalizedDescription()
    {
    	return getDescriptionCode();
//        return Context.getLocalizedMessage(getDescriptionCode(), null);
    }

    public String toString()
    {
        return getLocalizedDescription();
    }

    public Enum fromKey(String valorKey)
    {
        Enum out = null;
        Enum[] enums = this.getEnumValues();
        for (int e = 0; e < enums.length; e++)
        {
            if (valorKey.equals(enums[e].key))
            {
                out = enums[e];
                break;
            }
        }

        return out;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Enum)
        {
            Enum otherEnum = (Enum) obj;
            return otherEnum.key.equals(this.key);
        }
        return super.equals(obj);
    }

    public int hashCode()
    {
        return getKey().hashCode();
    }

    public int compareTo(Enum o)
    {
        return getLocalizedDescription().compareTo(o.getLocalizedDescription());
    }

    /**
     * Devuelve la posición en el enum.
     */
    public int getPosition()
    {
        int out = -1;
        Enum[] enums = this.getEnumValues();
        for (int e = 0; e < enums.length; e++)
        {
            if (this.getKey().equals(enums[e].key))
            {
                out = e;
                break;
            }
        }
        return out;
    }

}

