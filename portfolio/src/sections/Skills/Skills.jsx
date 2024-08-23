import styles from './SkillsStyles.module.css';
import checkMarkIconDark from '../../assets/checkmark-dark.svg';
import checkMarkIconLight from '../../assets/checkmark-light.svg';
import SkillList from '../../common/SkillList';
import { useTheme } from '../../common/ThemeContext';

function Skills() {
  const { theme } = useTheme();
  const checkMarkIcon = theme === 'light' ? checkMarkIconLight : checkMarkIconDark;

  return (
    <section id="skills" className={styles.container}>
      <h1 className="sectionTitle">Skills</h1>

      <div className={styles.skillList}>
        <SkillList src={checkMarkIcon} skill="Java" />
        <SkillList src={checkMarkIcon} skill="Spring framework" />
        <SkillList src={checkMarkIcon} skill="Spring Boot" />
        <SkillList src={checkMarkIcon} skill="Spring Cloud" />
        <SkillList src={checkMarkIcon} skill="Microservice" />
        <SkillList src={checkMarkIcon} skill="Hibernate" />
        <SkillList src={checkMarkIcon} skill="MYSQL" />
      </div>
      <hr />
      <div className={styles.skillList}>
        <SkillList src={checkMarkIcon} skill="HTML" />
        <SkillList src={checkMarkIcon} skill="CSS" />
        <SkillList src={checkMarkIcon} skill="JavaScript" />
        <SkillList src={checkMarkIcon} skill="Bootstrep" />
        <SkillList src={checkMarkIcon} skill="React JS" />
      </div>
      <hr />
      <div className={styles.skillList}>
        <SkillList src={checkMarkIcon} skill="GIT" />
        <SkillList src={checkMarkIcon} skill="Maven" />
        <SkillList src={checkMarkIcon} skill="Jenkins" />
        <SkillList src={checkMarkIcon} skill="Agile Process" />
      </div>
      
    </section>
  );
}

export default Skills;
