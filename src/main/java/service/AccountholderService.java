package service;

import java.util.List;

import bean.Accountholder;

public interface AccountholderService {

	public void persist(Accountholder entity);

	public void update(Accountholder entity);

	public Accountholder findById(String id);

	public void delete(String id);

	public List<Accountholder> findAll();

	public void deleteAll();

	public Accountholder findByCpfAndPassword(Long cpf, String password);

	Accountholder findByCpf(Long cpf);
}
