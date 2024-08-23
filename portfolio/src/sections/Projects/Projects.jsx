import styles from './ProjectsStyles.module.css';
import bankAPP from '../../assets/banlApp.png';
import expApp from '../../assets/expence.png';
import kafkaAPP from '../../assets/kafka.png';
import studentAPP from '../../assets/student.png';
import ProjectCard from '../../common/ProjectCard';

function Projects() {
  return (
    <section id="projects" className={styles.container}>
      <h1 className="sectionTitle">Projects</h1>
      <div className={styles.projectsContainer}>
        <ProjectCard
          src={bankAPP}
          link="https://github.com/catMansCodes/2024-All-Codes/tree/main/banking-application"
          h3="Banking Application"
          p="Banking App POC"
        />
        <ProjectCard
          src={expApp}
          link="https://github.com/catMansCodes/2024-All-Codes/tree/main/expense-tracker-application"
          h3="Expence Tracking "
          p="Expence Tracking App"
        />
        <ProjectCard
          src={kafkaAPP}
          link="https://github.com/catMansCodes/2024-All-Codes/tree/main/spring-boot-kafka-projects"
          h3="Spring Boot Kafka Apps"
          p="Spring Boot Kafka POCs"
        />
        <ProjectCard
          src={studentAPP}
          link="https://github.com/catMansCodes/2024-All-Codes/tree/main/student-management-system"
          h3="Student Management App"
          p="Student App"
        />
      </div>
    </section>
  );
}

export default Projects;
