package pokemon;
/**
 * Subclass of <i>Pokemon</i> class.
 * <p>
 * Inherited the attributes and methods of the class <i>Pokemon</i> and
 * overrides some specific methods of it.
 */
public class Electric extends Pokemon {
	/**
	  Initializes a newly created <i>Electric</i> object
	  with the specified parameters.
	  <p>
	  The parameter <i>damageDone</i> is turned to zero by default.
	  @param name  a <code>String</code> that indicates the name of this Pokemon.
	  @param HP  an <code>int</code> that indicates the HP of this Pokemon.
	  @param damageDone  an <code>int</code> that indicates the damage done by this Pokemon.
	*/
	public Electric(String name, int HP, int damageDone) {
		super(name, HP, damageDone);
	}
	/**
	  Initializes a newly created <i>Electric</i> object
	  with the specified parameters.
	  @param name  a <code>String</code> that indicates the name of this Pokemon.
	  @param HP  an <code>int</code> that indicates the HP of this Pokemon.
	  @param damageDone  an <code>int</code> that indicates the damage done by this Pokemon.
	  @param damageReceived  an <code>int</code> that indicates the damage received by this Pokemon.
	*/
	public Electric(String name, int HP, int damageDone, int damageReceived) {
		super(name, HP, damageDone, damageReceived);
	}
	
	@Override
	public void attackedBy(Pokemon pokemon) {
		pokemon.attackElectric(this);
	}
	
	@Override
	public void attackWater(Pokemon pokemon) {
		this.superEffectiveAttack(pokemon);
	}
	
	@Override
	public void attackElectric(Pokemon pokemon) {
		this.nonEffectiveAttack(pokemon);
	}
	
	@Override
	public void attackGround(Pokemon pokemon) {
		this.nonEffectiveAttack(pokemon);
	}
}