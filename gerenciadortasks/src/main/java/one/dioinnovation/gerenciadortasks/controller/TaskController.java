package one.dioinnovation.gerenciadortasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import one.dioinnovation.gerenciadortasks.model.Task;
import one.dioinnovation.gerenciadortasks.model.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    

    /**
     * Retorna a lista de todas as tarefas no modelo do Spring e a envia para a view "tasks"
     *
     * @param  model  o modelo do Spring para a view
     * @return        o nome da view "tasks"
     */
    @GetMapping
    public String listarTodasAsTarefas(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks";
    }

    /**
     * Retorna uma tarefa específica com base no ID, adiciona-a ao modelo do Spring e a envia para a view "task"
     *
     * @param  id     o ID da tarefa a ser procurada
     * @param  model  o modelo do Spring para a view
     * @return        o nome da view "task"
     */
    @GetMapping("/{id}")
    public String procurarTarefa(@PathVariable Long id, Model model) {
        // Busca a tarefa com base no ID fornecido
        Task task = taskService.findById(id);
        // Adiciona a tarefa encontrada ao modelo do Spring
        model.addAttribute("task", task);
        // Retorna o nome da view "task"
        return "task";
    }

    /**
     * Retorna uma nova instância de Task e a adiciona ao modelo do Spring,
     * em seguida, envia para a view "task-form" para que o usuário possa
     * preencher os detalhes da tarefa.
     *
     * @param  model  o modelo do Spring para a view
     * @return        o nome da view "task-form"
     */
    @GetMapping("/new")
    public String novaTarefa(Model model) {
        // Cria uma nova instância de Task
        Task task = new Task();
        // Adiciona a tarefa ao modelo do Spring
        model.addAttribute("task", task);
        // Retorna o nome da view "task-form"
        return "task-form";
    }

    /**
     * Salva uma tarefa no banco de dados com base nos dados fornecidos via
     * {@link ModelAttribute} e redireciona para a página de listagem de tarefas.
     *
     * @param  task   a instância de Task com os dados a serem salvos
     * @return        o nome da view a ser redirecionada, que nesse caso é "redirect:/tasks"
     */
    @PostMapping
    public String salvarTarefa(@ModelAttribute Task task) {
        // Salva a tarefa no banco de dados
        taskService.save(task);
        // Redireciona para a página de listagem de tarefas
        return "redirect:/tasks";
    }

    /**
     * Retorna a página de edição de tarefas, preenchida com os dados da tarefa
     * encontrada com base no ID fornecido via {@link PathVariable}.
     *
     * @param  id     o ID da tarefa a ser editada
     * @param  model  o modelo do Spring para a view
     * @return        o nome da view "task-form"
     */
    @GetMapping("/edit/{id}")
    public String editarTarefa(@PathVariable Long id, Model model) {
        // Encontra a tarefa no banco de dados com base no ID fornecido
        Task task = taskService.findById(id);
        // Adiciona a tarefa ao modelo do Spring
        model.addAttribute("task", task);
        // Retorna o nome da view "task-form"
        return "task-form";
    }

    /**
     * Deleta uma tarefa do banco de dados com base no ID fornecido via
     * {@link PathVariable} e redireciona para a página de listagem de tarefas.
     *
     * @param  id     o ID da tarefa a ser deletada
     * @return        o nome da view a ser redirecionada, que nesse caso é "redirect:/tasks"
     */
    @GetMapping("/delete/{id}")
    public String deletarTarefa(@PathVariable Long id) {
        // Deleta a tarefa do banco de dados
        taskService.deleteById(id);
        // Redireciona para a página de listagem de tarefas
        return "redirect:/tasks";
    }
        


}
