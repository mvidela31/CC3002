package pokemon;
/**
 * Abstract class that defines the basic attributes, constructors, setters 
 * and getters of the <i>Pokemon</i> object and implements the Pokemon's
 * battle attacks according to the weaknesses and strengths of the 
 * different types of Pokemons.
 *
 * @author  Miguel Videla A.
 * @version 1.0
 * @since   2017-04-09
 */
public abstract class Pokemon implements IAttack {
	
	// Attributes.
	/**
	 * Name of the Pokemon.
	 */
	private String name = "Unnamed";
	/**
	 * HP of the Pokemon.
	 */
	private int HP = 100;
	/**
	 * Damage received by the Pokemon.
	 */
	private int damageReceived = 0;
	/**
	 * Damage done by the Pokemon.
	 */
	private int damageDone = 1;
	
	// Constructors.
	/**
	  Initializes a newly created <i>Pokemon</i> object
	  with the specified parameters.
	  <p>
	  The parameter <i>damageDone</i> is turned to zero by default.
	  @param name  a <code>String</code> that indicates the name of this Pokemon.
	  @param HP  an <code>int</code> that indicates the HP of this Pokemon.
	  @param damageDone  an <code>int</code> that indicates the damage done by this Pokemon.
	*/
	public Pokemon(String name, int HP, int damageDone) {
		this.name = name;
		this.HP = HP;
		this.damageDone = damageDone;
	}
	/**
	  Initializes a newly created <i>Pokemon</i> object
	  with the specified parameters.
	  @param name  a <code>String</code> that indicates the name of this Pokemon.
	  @param HP  an <code>int</code> that indicates the HP of this Pokemon.
	  @param damageDone  an <code>int</code> that indicates the damage done by this Pokemon.
	  @param damageReceived  an <code>int</code> that indicates the damage received by this Pokemon.
	*/
	public Pokemon(String name, int HP, int damageDone, int damageReceived) {
		this.name = name;
		this.HP = HP;
		this.damageDone = damageDone;
		this.damageReceived = damageReceived;
	}
	
	// Getters.
	/**
	 * Name of the Pokemon. 
	 *
	 * @return  The current value of this Pokemon's name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * HP of the Pokemon. 
	 *
	 * @return  The current value of this Pokemon's HP.
	 */
	public int getHP() {
		return this.HP;
	}
	/**
	 * Damage received by the Pokemon. 
	 *
	 * @return  The current value of this Pokemon's damageReceived.
	 */
	public int getDamageReceived() {
		return this.damageReceived;
	}
	/**
	 * Damage done by the Pokemon. 
	 *
	 * @return  The current value of this Pokemon's damageDone.
	 */
	public int getDamageDone() {
		return this.damageDone;
	}
	
	// Setters.
	/**
	 * Set the name of this Pokemon. 
	 *
	 * @param  name New value of this Pokemon's name.
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * Set the HP of this Pokemon. 
	 *
	 * @param  HP New value of this Pokemon's HP.
	 */
	public void setHP(int HP) {
		this.HP=HP;
	}	
	/**
	 * Set the damage received by this Pokemon. 
	 *
	 * @param  damageReceived New value of this Pokemon's damageReceived.
	 */
	public void setDamageReceived(int damageReceived) {
		this.damageReceived=damageReceived;
	}
	/**
	 * Set the damage done by this Pokemon. 
	 *
	 * @param  damageDone New value of this Pokemon's damageDone.
	 */
	public void setDamageDone(int damageDone) {
		this.damageDone=damageDone;
	}
	
	// Abstract method.
	/**
	 * Abstract method that indicates the subclasses attacks methods to run.
	 * <p>
	 * In every subclass of the class <i>Pokemon</i> this method is redefined to
	 * implement the correct attack according to the attacked Pokemon type.
	 *
	 * @param  pokemon  a <i>Pokemon</i> that attack.
	 */
	abstract void attackedBy(Pokemon pokemon);
	
	// Attack method.
	public void attack(Pokemon pokemon) {
		if (!this.isDefeated()){
			pokemon.attackedBy(this);
		}
	}
	
	// Attack effectiveness methods.
	public void normalAttack(Pokemon pokemon) {
		pokemon.setDamageReceived(pokemon.getDamageReceived()+this.getDamageDone());
	}
	
	public void nonEffectiveAttack(Pokemon pokemon) {
		if (this.getDamageDone()-20 > 0){
			pokemon.setDamageReceived(pokemon.getDamageReceived()+this.getDamageDone()-20);
		}
	}
	
	public void superEffectiveAttack(Pokemon pokemon) {
		pokemon.setDamageReceived(pokemon.getDamageReceived()+this.getDamageDone()*2);
	}
	
	// Attack objective methods.
	public void attackGrass(Pokemon pokemon) {
		this.normalAttack(pokemon);
	}
	
	public void attackFire(Pokemon pokemon) {
		this.normalAttack(pokemon);
	}
	
	public void attackWater(Pokemon pokemon) {
		this.normalAttack(pokemon);
	}
	
	public void attackElectric(Pokemon pokemon) {
		this.normalAttack(pokemon);
	}
	
	public void attackGround(Pokemon pokemon) {
		this.normalAttack(pokemon);
	}
	
	public void attackPsychic(Pokemon pokemon) {
		this.normalAttack(pokemon);
	}
	
	public void attackFighting(Pokemon pokemon) {
		this.normalAttack(pokemon);
	}
	
	public void attackNormal(Pokemon pokemon) {
		this.normalAttack(pokemon);
	}
	
	// Defeat condition method.
	public boolean isDefeated() {
		if (this.getDamageReceived()>=this.getHP()) {
			return true;
		}
		else {
			return false;
		}
	}
}