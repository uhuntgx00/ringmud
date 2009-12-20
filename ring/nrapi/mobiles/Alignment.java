package ring.nrapi.mobiles;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ring.nrapi.data.RingConstants;
import ring.util.TextParser;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement
@XmlType(
namespace = RingConstants.RING_NAMESPACE,
propOrder = {
	"moral",
	"ethical"
})
/**
 * Class that represents the alignment of something in the game. Generally,
 * this is a Mobile. However, sometimes items can have alignments.
 * @author projectmoon
 */
public class Alignment implements Serializable {
	public static final long serialVersionUID = 1;
	
	/**
	 * Enum describing ethical components: Lawful, Neutral, or Chaotic.
	 */
	@XmlType
	public enum Ethical { 
		LAWFUL("[B][WHITE]Lawful[R]"), NEUTRAL("[R][CYAN]Neutral[WHITE]"), CHAOTIC("[B][GREEN]Chaotic[R][WHITE]"); 
		
		private String name;
		
		Ethical(String name) { this.name = name; }
		
		public String toString() { return name; }
	};
	
	/**
	 * Enum describing moral components: Good, Neutral, or Evil.
	 */
	@XmlType
	public enum Moral {
		GOOD("[B][WHITE]Good[R]"), NEUTRAL("[R][CYAN]Neutral[WHITE]"), EVIL("[B][RED]Evil[R][WHITE]");
		
		private String name;
		
		Moral(String name) { this.name = name; }
		
		public String toString() { return name; }
	};

	//The two components of an alignment.
	private Ethical ethical;
	private Moral moral;

	/**
	 * Creates a new Alignment object set to True Neutral alignment.
	 */
	public Alignment() {
		ethical = Ethical.NEUTRAL;
		moral = Moral.NEUTRAL;
	}

	/**
	 * Creates the alignment of the specified ethical and moral components.
	 */
	public Alignment(Ethical ethical, Moral moral) {
		this.ethical = ethical;
		this.moral = moral;
	}

	/**
	 * Returns a user-friendly representation of this Alignment. This
	 * is what gets sent back to the user.
	 */
	public String toString() {
		String res = ethical.toString() + " " + moral.toString();

		//Handle true neutral alignment
		if (res.equals(Ethical.NEUTRAL.toString() + " " + Moral.NEUTRAL.toString())) {
			res = "[R][CYAN]True Neutral[WHITE]";
		}
		
		return res;		
	}
	
	/**
	 * Returns a user-friendly representation of this Alignment. This
	 * is what gets sent back to the user.
	 */
	public String toNonFormattedString() {
		String res = ethical.toString() + " " + moral.toString();

		//Handle true neutral alignment
		if (res.equals(Ethical.NEUTRAL.toString() + " " + Moral.NEUTRAL.toString())) {
			res = "[R][CYAN]True Neutral[WHITE]";
		}
		
		res = TextParser.stripFormatting(res);
		
		return res;
	}	

	@XmlAttribute
	public Ethical getEthical() {
		return ethical;
	}
	
	public void setEthical(Ethical ethical) {
		this.ethical = ethical;
	}

	@XmlAttribute
	public Moral getMoral() {
		return moral;
	}
	
	public void setMoral(Moral moral) {
		this.moral = moral;
	}
}
