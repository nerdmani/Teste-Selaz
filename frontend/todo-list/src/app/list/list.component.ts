import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TaskService } from '../services/task.service';

@Component({
    selector: 'app-list',
    imports: [CommonModule],
    templateUrl: './list.component.html',
    styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  tasks: { id: number, title: string, description: string }[] = [];

  constructor(private taskService: TaskService) {}

  ngOnInit() {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.getTasks().subscribe((data) => {
      this.tasks = data;
    });
  }

  addTask(title: string, description: string, event: Event) {
    event.preventDefault();

    if (title && description) {
      const newTask = { title, description };
      this.taskService.createTask(newTask).subscribe((task) => {
        this.tasks = [...this.tasks, task]; 
      });
    }
  }

  editTask(id: number) {
    const task = this.tasks.find((task) => task.id === id);
    if (task) {
      const updatedTitle = prompt('Novo título:', task.title);
      const updatedDescription = prompt('Nova descrição:', task.description);

      if (updatedTitle && updatedDescription) {
        const updatedTask = { ...task, title: updatedTitle, description: updatedDescription };
        this.taskService.updateTask(id, updatedTask).subscribe(() => {
          this.tasks = this.tasks.map((t) => (t.id === id ? updatedTask : t));
        });
      }
    }
  }

  deleteTask(id: number) {
    this.taskService.deleteTask(id).subscribe(() => {
      this.tasks = this.tasks.filter((task) => task.id !== id);
    });
  }
}
