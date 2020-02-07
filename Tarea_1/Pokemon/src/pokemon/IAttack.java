package pokemon;

public interface IAttack {
	
	// Attack method.
	/**
	 * Set the damage received of the attacked <i>Pokemon</i> according to weaknesses and strengths
	 * of the different subclasses of the superclass <i>Pokemon</i>.
	 * <p>
	 *  If the attacker <i>Pokemon</i> is defeated this method does anything.
	 *  
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	public void attack(Pokemon pokemon);
	
	// Attack effectiveness.
	/**
	 * Set the damage received of the attacked <i>Pokemon</i> according to the next formula:
	 * <p>
	 * <i>damageReceived += damageDone</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void normalAttack(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Pokemon</i> according to the next formula:
	 * <p>
	 * <i>damageReceived += damageDone - 20</i>
	 * <p>
	 * If the value of the damageDone by the attacker Pokemon is minor than 20, 
	 * the value of the damageReceived of the attacked Pokemon will not be modified.
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void nonEffectiveAttack(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Pokemon</i> according to the next formula:
	 * <p>
	 * <i>damageReceived += 2*damageDone</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void superEffectiveAttack(Pokemon pokemon);
	
	// Attack objective.
	/**
	 * Set the damage received of the attacked <i>Grass</i> pokemon according to the attack
	 * effectiveness determined by the type of the attacker pokemon.
	 * <p>
	 * The effectiveness of the attack can be:<br>
	 * <i>- normalAttack</i><br>
	 * <i>- nonEffectiveAttack<br>
	 * <i>- superEffectiveAttack</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void attackGrass(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Fire</i> pokemon according to the attack
	 * effectiveness determined by the type of the attacker pokemon.
	 * <p>
	 * The effectiveness of the attack can be:<br>
	 * <i>- normalAttack</i><br>
	 * <i>- nonEffectiveAttack<br>
	 * <i>- superEffectiveAttack</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void attackFire(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Water</i> pokemon according to the attack
	 * effectiveness determined by the type of the attacker pokemon.
	 * <p>
	 * The effectiveness of the attack can be:<br>
	 * <i>- normalAttack</i><br>
	 * <i>- nonEffectiveAttack<br>
	 * <i>- superEffectiveAttack</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void attackWater(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Electric</i> pokemon according to the attack
	 * effectiveness determined by the type of the attacker pokemon.
	 * <p>
	 * The effectiveness of the attack can be:<br>
	 * <i>- normalAttack</i><br>
	 * <i>- nonEffectiveAttack<br>
	 * <i>- superEffectiveAttack</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void attackElectric(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Ground</i> pokemon according to the attack
	 * effectiveness determined by the type of the attacker pokemon.
	 * <p>
	 * The effectiveness of the attack can be:<br>
	 * <i>- normalAttack</i><br>
	 * <i>- nonEffectiveAttack<br>
	 * <i>- superEffectiveAttack</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void attackGround(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Psychic</i> pokemon according to the attack
	 * effectiveness determined by the type of the attacker pokemon.
	 * <p>
	 * The effectiveness of the attack can be:<br>
	 * <i>- normalAttack</i><br>
	 * <i>- nonEffectiveAttack<br>
	 * <i>- superEffectiveAttack</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void attackPsychic(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Fighting</i> pokemon according to the attack
	 * effectiveness determined by the type of the attacker pokemon.
	 * <p>
	 * The effectiveness of the attack can be:<br>
	 * <i>- normalAttack</i><br>
	 * <i>- nonEffectiveAttack<br>
	 * <i>- superEffectiveAttack</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void attackFighting(Pokemon pokemon);
	/**
	 * Set the damage received of the attacked <i>Normal</i> pokemon according to the attack
	 * effectiveness determined by the type of the attacker pokemon.
	 * <p>
	 * The effectiveness of the attack can be:<br>
	 * <i>- normalAttack</i><br>
	 * <i>- nonEffectiveAttack<br>
	 * <i>- superEffectiveAttack</i>
	 *
	 * @param  pokemon  a <i>Pokemon</i> which it's damageReceived parameter will be modified.
	 */
	void attackNormal(Pokemon pokemon);
	
	// Defeat condition.
	/**
	 * Indicates if the current <i>Pokemon</i> is defeated.
	 * <p>
	 * The condition of defeat is determined by the next formula:
	 * <p>
	 * <i>damageReceived >= HP</i>
	 *
	 * @param  void  
	 * @return A <i>boolean</i> value that indicates if the current <i>Pokemon</i> is defeated.
	 */
	boolean isDefeated();
}